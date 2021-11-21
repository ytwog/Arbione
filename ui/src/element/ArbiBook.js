import React from 'react';
import axios from 'axios';
import DenseTable from "./DenseTable";
import Checkbox from "@material-ui/core/Checkbox";
import TableContainer from "@material-ui/core/TableContainer";
import Paper from "@material-ui/core/Paper";
import Table from "@material-ui/core/Table";
import TableHead from "@material-ui/core/TableHead";
import TableRow from "@material-ui/core/TableRow";
import TableCell from "@material-ui/core/TableCell";
import TableBody from "@material-ui/core/TableBody";

const orderBookPath = 'http://localhost:8080/arbione/api/market/okex/books';

class ArbiBook extends React.Component {
    headers = [
        {text: 'depth price', key: 0, id: '0'},
        {text: 'size', key: 1, id: '1'},
        {text: 'liquidated orders', key: 2, id: '2'},
        {text: 'orders', key: 3, id: '3'}
    ]

    refreshIntervalId;
    targetProxy

    constructor(props) {
        super(props);
        this.instId = props.item.instId;
        this.addBook = props.addBook;
        this.onChange = props.onChange;
        this.setState({load: 'loading', refresh: false})
    }

    getOrderBook(instId, sz) {
        const instIdQuery = instId ? ('instId=' + instId + '&') : '';
        const szQuery = sz ? ('sz=' + sz) : '';
        axios.get(orderBookPath + '?' + instIdQuery + szQuery)
            .then(response => {
                this.setState({tableData: response.data, load: 'loaded', refresh: true})
            })
            .catch(q => console.error("Failed to fetch", q));
    }

    componentDidMount() {
        this.addBook.refreshCallback = this.getOrderBook.bind(this);
    }

    render() {
        if(this.addBook && this.addBook.add) {

            if(this.state && this.state.load === 'loaded') {
                return (
                    <div>
                        <Checkbox
                            onChange={this.onChange}
                            inputProps={{ 'aria-label': 'primary checkbox' }}
                            name={this.instId}
                            checked={true}
                        />
                        <TableContainer component={Paper}>
                            <Table size="small" aria-label="a dense table">
                                <TableHead>
                                    <TableRow>
                                        {this.headers.map((header) => {
                                            return (
                                                <TableCell key={header.key} align="right">{header.text}</TableCell>
                                            );
                                        })}
                                    </TableRow>
                                </TableHead>
                                <TableBody>
                                    {this.state.tableData[0].asks.map((row => {
                                        return (
                                            <TableRow> {
                                                row.map((cell) => {
                                                return (
                                                <TableCell align="right">{cell}</TableCell>
                                            )})}
                                            </TableRow>
                                        )}
                                    ))}
                                </TableBody>
                            </Table>
                        </TableContainer>
                    </div>
                )
            } else {
                return (
                    <div>
                        Loading
                    </div>
                );
            }
        } else {
            return (
                <Checkbox
                    checked={false}
                    onChange={this.onChange}
                    inputProps={{ 'aria-label': 'primary checkbox' }}
                    name={this.instId}
                />
            )
        }
    }
}

export default ArbiBook;
import React from 'react';
import axios from 'axios';
import DenseTable from "./DenseTable";
import Checkbox from '@material-ui/core/Checkbox';
import {Button} from "@material-ui/core";
import ArbiBook from "./ArbiBook";

const tickersPath = 'http://localhost:8080/arbione/api/market/okex/tickers';

let bookSize = 8;

class ArbiTable extends React.Component {
    addBook = new Map();
    tableRefresh;
    headers = [
        {text: 'Instrument ID', key: 0, id: 'instId'},
        // {text: 'Best ask price', key: 1, id: 'askPx'},
        // {text: 'Best ask size', key: 2, id: 'askSz'},
        // {text: 'Best bid price', key: 3, id: 'bidPx'},
        // {text: 'Best bid size', key: 4, id: 'bidSz'},
        // {text: 'Highest price (24 hours)', key: 5, id: 'high24h'},
        // {text: 'Lowest price (24 hours)', key: 6, id: 'low24h'},
        // {text: 'Last traded price', key: 7, id: 'last'},
        // {text: 'Last traded size',  key: 8, id: 'lastSz'},
    ]
    bookColumn = {text: 'Order book', key: 9, id: 'orderBook', checkout: ArbiBook}

    constructor(props) {
        super(props);
        this.handleChange.bind(this);
        this.setState({load: 'loading'})
    }

    componentDidMount() {
        this.getArbiData(true);
        this.tableRefresh = setInterval(this.initRefresh.bind(this), 500);
    }

    initRefresh() {
        this.getArbiData(false);
    }

    getArbiData(bookIncluded) {
        axios.get(tickersPath)
            .then(response => {
                if(bookIncluded) {
                    response.data.forEach(q => {
                        this.addBook.set(q, {add: false, refreshCallback: null, refreshIntervalId: null})
                    })
                }
                this.setState({tableData: response.data, load: 'loaded'})
            })
            .catch(q => console.error("Failed to fetch", q));
    }

    handleChange(event) {
        let targetName = event.target.name;
        let targetChecked = event.target.checked;
        console.log(targetName + ' is ' + (targetChecked ? '' : ' not ') + 'checked');
        let addBookElement = this.addBook.get(targetName);
        addBookElement.add = targetChecked;
        addBookElement.refreshCallback(targetName, bookSize);
        if(targetChecked) {
            addBookElement.refreshIntervalId = setInterval(addBookElement.refreshCallback, 1000, targetName, bookSize);
        } else {
            clearInterval(addBookElement.refreshIntervalId);
        }
    }

    render() {
        if(this.state && this.state.load === 'loaded') {
            return (
                <div>
                    <div className={'Abri-toolbar'}>
                    </div>
                    <div>
                        <DenseTable headers={this.headers.concat([this.bookColumn])}
                                    rows={this.state.tableData}
                                    onChange={this.handleChange.bind(this)}
                                    addBook={this.addBook}
                        />
                    </div>
                </div>
            );
        } else {
            return (
                <p>Loading</p>
            );
        }
    }
}

export default ArbiTable;
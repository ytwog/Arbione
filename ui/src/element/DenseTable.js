import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableContainer from '@material-ui/core/TableContainer';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';

const useStyles = makeStyles({
    table: {
        minWidth: 650,
    },
});

export default function DenseTable(tableData) {
    const headers = tableData.headers;
    const rows = tableData.rows;
    const onChange = tableData.onChange;
    const addBook = tableData.addBook;
    const classes = useStyles();

    return (
        <TableContainer component={Paper}>
            <Table className={classes.table} size="small" aria-label="a dense table">
                <TableHead>
                    <TableRow>
                        {headers.map((header) => {
                            return (
                                <TableCell key={header.key} align="right">{header.text}</TableCell>
                            );
                        })}
                    </TableRow>
                </TableHead>
                <TableBody>
                    {rows.map((row) => (
                        <TableRow key={row}>
                            {headers.map((header) => {
                                return (
                                    <TableCell key={header.key} align="right">
                                            {header.checkout
                                                ? <header.checkout item={row} onChange={onChange} addBook={addBook.get(row)}/>
                                                : (row.hasOwnProperty(header.id) ? row[header.id] : '-')}
                                    </TableCell>
                                );
                            })}
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
        </TableContainer>
    );
}
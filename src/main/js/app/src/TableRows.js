import React from 'react';
import TableRow from './TableRow.js';

export default function TableRows(props) {

    return props.items.map((data, key) => {
        return (
            <TableRow
                name={data.name}
                weight={data.weight}
                colour={data.colour}
                cost={data.cost}
                country={data.country}
                key={key}
            />
        );
    });
}
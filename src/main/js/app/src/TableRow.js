import React from 'react';

export default function TableRow(props) {

    const getCssForBackground = (colour) => {
        return {
            backgroundColor: `rgb(${colour.r} ,${colour.g} , ${colour.b})`
        };
    };

    return (
        <tr>
            <td>{ props.name }</td>
            <td>{ props.weight } kg</td>
            <td style={ getCssForBackground(props.colour) }></td>
            <td>{ props.cost.toFixed(2) } SEK</td>
            <td>{ props.country }</td>
        </tr>
    );
}
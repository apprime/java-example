import React from 'react';
import List from './List.js';
import TableRow from './TableRow.js';
import TableRows from './TableRows.js';

import { act } from "react-dom/test-utils";
import {render, fireEvent, screen} from '@testing-library/react'
import axios from 'axios';

jest.mock('axios');

describe('List view', () => {
    it('lists each box as a row in a table', async () => {
        const spy = jest.spyOn(axios, 'get');
        const { getById, getByText, getByPlaceholderText, queryByText } = render(<List />);
        console.log(getByText());
        expect().to.have.length(1);
        expect(spy).toHaveBeenCalledWith("/box");
    });

    it('sums the cost of each row', () => {
      expect(true).toEqual(true);
    });

    it('sums the weight of each row', () => {
        expect(true).toEqual(true);
    });

    it('refreshes the view upon button click', () => {
        expect(true).toEqual(true);
    });
});

import M from "materialize-css";
import React, { useState, useEffect } from 'react';
import useForm from "react-hook-form";
import { ChromePicker } from 'react-color';
import CountryOptions from './CountryOptions';
import { Button, Icon } from 'react-materialize';
import axios from 'axios';

export default function Add() {

    const {
        handleSubmit,
        register,
        unregister,
        errors,
        getValues,
        setValue,
     } = useForm();

    const [displayColorPicker, setDisplayColorPicker] = useState(false);

    const popover = { position: 'absolute', zIndex: '2' }
    const cover = {
        position: 'fixed',
        top: '0px',
        right: '0px',
        bottom: '0px',
        left: '0px',
    }

    //colourpicker is a custom input, we register it manually.
    useEffect(() => {
        register(
            { name: 'colour' },
            { validate: value => !colourContainsBlue(value) || "Blue colour of any kind is not allowed" }
        );

        return () => unregister('colour');
    }, [register, unregister]);

    useEffect(() => {
        M.AutoInit();
    }, []);

    const colourChanged = (newColour) => setValue("colour", newColour.rgb);
    const colourContainsBlue = (colour) => colour.b > 0;
    const handleClick = () => setDisplayColorPicker(!displayColorPicker);
    const handleClose = () => setDisplayColorPicker(false);

    const getCssForBackground = () => {
        let values = getValues();
        if(values && values.colour){
            return {
                height: "36px",
                width: "36px",
                backgroundColor: `rgb(${values.colour.r} ,${values.colour.g} , ${values.colour.b})`
            };
        }
    };

    const onSubmit = async( values) => {
        try{
            let result = await axios.post('/box', getValues());
             M.toast({html: `New box called ${result.data.name} has been created.`})
        } catch(error) {
            //Pretend nothing happened.
        }
    };

    return (
    <>
        <h5>Enter your information here</h5>
        <form onSubmit={ handleSubmit(onSubmit) } className="col s12">

            <div className="input-field col s12">
                <input
                    type="text"
                    name="name"
                    ref={ register({ required: "Enter a name" }) }
                />
                <label htmlFor="name">Name</label>
            </div>

            <div className="input-field col s12">
                <input
                    type="number"
                    min="1"
                    max="9999"
                    name="weight"
                    ref={ register({ required: "Enter a weight", pattern: /^[\d]+$/i, min: 1 }) }
                />
                <label htmlFor="weight">Weight (kgs)</label>
            </div>

            <div className="row">
                <div className="input-field col">
                    <div
                        className="z-depth-1"
                        style={ getCssForBackground() }
                    >
                    </div>
                    { displayColorPicker ?
                        <div style={ popover }>
                        <div style={ cover } onClick={ handleClose }/>
                            <ChromePicker
                                disableAlpha={ true }
                                color={getValues() && getValues().colour}
                                onChangeComplete={ colourChanged }
                            />
                        </div>
                     : null }
                 </div>
                <div className="input-field col v-align-wrapper">
                    <Button type="button" onClick={ handleClick }>Pick Colour</Button>
                </div>
                <div className="input-field col v-align-wrapper red-text text-darken-1">
                     {errors.colour && errors.colour.message}
                </div>
            </div>

            <select
                defaultValue=""
                type='select'
                label="Select"
                name="country"
                ref={ register({ required: "You must choose a country" }) }
            >
                <option value="" disabled>Choose a country</option>
                <CountryOptions />
            </select>

            <div className="input-field col red-text text-darken-1">
                { errors.country && errors.country.message }
            </div>

            <Button
                className="right"
                node="button"
                type="submit"
                waves="light"
            >
              Submit
              <Icon right>
                send
              </Icon>
            </Button>
        </form>
    </>
  );
}


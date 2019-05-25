import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';

const styles = theme => ({
  container: {
    display: 'flex',
    flexWrap: 'wrap',
    justifyContent: 'flex-end',
  },
  textField: {
    marginLeft: theme.spacing.unit,
    marginRight: theme.spacing.unit,
    width: 250,
  },
  
});

const TextFieldMargins = props => {

  const { classes } = props;
  
  return (
    <form className={classes.container} noValidate autoComplete="off">
      <TextField
        id="emailField"
        defaultValue=""
        className={classes.textField}
        helperText="E-mail"
        margin="dense"
        onChange={ props.onChange('email')}
      />
      <TextField
        id="firstNameField"
        defaultValue=""
        className={classes.textField}
        helperText="Prenume"
        margin="dense"
        onChange={props.onChange('firstName')}
      />
      <TextField
        id="lastNameField"
        defaultValue=""
        className={classes.textField}
        helperText="Nume"
        margin="dense"
        onChange={props.onChange('lastName')}
      />
      <TextField
        id="tokenField"
        defaultValue=""
        className={classes.textField}
        helperText="Token. Dupa prima comanda vei putea comanda doar cu acest token"
        margin="dense"
        type="password"
        onChange={props.onChange('token')}
      />
    </form>
  );
};

TextFieldMargins.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(TextFieldMargins);
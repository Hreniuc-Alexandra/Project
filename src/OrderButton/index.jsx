import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import Button from '@material-ui/core/Button';

const styles = theme => ({
  button: {
    margin: theme.spacing.unit,
  },
  buttonContainer:{
    display: 'flex',
    flexWrap: 'wrap',
    justifyContent: 'flex-end',
  },
  input: {
    display: 'none',
  },
});

function OutlinedButtons(props) {
  const { classes } = props;
  return (
    <div className={classes.buttonContainer}>
      <Button onClick={props.onClick} variant="outlined" className={classes.button}>
        {props.buttonName}
      </Button>
    </div>
  );
}

OutlinedButtons.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(OutlinedButtons);
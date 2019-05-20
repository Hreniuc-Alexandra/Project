import React from 'react';
import PropTypes from 'prop-types';
import { withStyles } from '@material-ui/core/styles';
import List from '@material-ui/core/List';
import ListItem from '@material-ui/core/ListItem';
import ListItemText from '@material-ui/core/ListItemText';

const styles = theme => ({
  root: {
    width: '100%',
    maxWidth: 460,
    backgroundColor: theme.palette.background.paper
  },
  listItem:{
    float: 'left',
  }
});

class SelectedListItem extends React.Component {
    
  state = {
    selectedIndex: 0,
  };
  render() {
    return (
      <div className={this.props.root}>
        <List component="nav">
          <ListItem className={this.props.listItem} button selected={this.state.selectedIndex === this.props.dish.key} onClick = {this.props.onClick}>
            <ListItemText primary={this.props.dish.menuItem + " - " + this.props.dish.price} />
          </ListItem>
        </List>
      </div>
    );
  }
}

SelectedListItem.propTypes = {
  classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(SelectedListItem);
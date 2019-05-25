import React, { Component } from 'react';
import './App.css';
import { Restaurant } from './Restaurant/Restaurant.js'
import './Restaurant/Restaurant.css';
import TextFieldMargins from '../src/TopTextFields'
import OutlinedButtons from '../src/OrderButton'
import axios from 'axios';

class App extends Component {

  state = {
    restaurants: [   
    
    ],
    orderDTO:{
      email:'',
      firstName:'',
      lastName:'',
      token:'',
      extraFees:'',
      orders:[]
    }
  }

  componentDidMount(){
    axios.get("http://localhost:8080/api/v1/restaurants").then(res=>{
      this.setState({restaurants: res.data.result})
    });
  }
  
  editOrders = (orderId) =>{
    let newOrderDto=this.state.orderDTO.orders.filter(stateOrder=>orderId===stateOrder.dishId);
    if(newOrderDto.length===0){
      newOrderDto = Object.assign({}, {dishId: orderId, quantity: 1})
    }else{
      newOrderDto[0].quantity=newOrderDto[0].quantity+1;
    }
    let otherOrders = this.state.orderDTO.orders.filter(stateOrder => orderId!==stateOrder.dishId);
    let updatedState=otherOrders.concat(newOrderDto);
    this.setState(Object.assign(this.state.orderDTO.orders, updatedState))
  
  }

  showMenuHandler=(index)=>{
    let newSt = this.state.restaurants[index];
    newSt.displayMenu = !newSt.displayMenu;
    this.setState(newSt);
  }

  handleChange = prop => event => {
    Object.assign(this.state.orderDTO, { [prop]: event.target.value })
    console.log(this.state.orderDTO)
  };
  
  render() {
    
    return (
      <div className="App">
        <div><TextFieldMargins 
          onChange={(event)=>this.handleChange(event)}
          /> 
        </div>
        <div><OutlinedButtons/></div>
        <div className="zonaTaText">
          Restaurante din zona ta!
        </div>
        <div className="restaurante">
          {this.state.restaurants.map((restaurant,index) => {
            return <Restaurant 
              showMenu={() => {this.showMenuHandler(index)}} 
              onOrderClick={this.editOrders} 
              menu={restaurant.menu} 
              imagine={restaurant.imagine} 
              nume={restaurant.nume} 
              key={index} 
              displayMenu={restaurant.displayMenu} 
              discount={restaurant.discount}/>
          })}
        </div>
      </div>
    );
  }
}
export default App;

import React, { Component } from 'react';
import './App.css';
import { Restaurant } from './Restaurant/Restaurant.js'
import './Restaurant/Restaurant.css';
import TextFieldMargins from '../src/TopTextFields'
import OutlinedButtons from '../src/OrderButton'
import SimpleMenu from '../src/CartDropdown'
import axios from 'axios';

class App extends Component {

  state = {
    restaurants: [   
    
    ],
    orderDTO:{
      email:null,
      firstName:null,
      lastName:null,
      token:null,
      extraFees:null,
      orders:[]
    },
    dishes:[

    ]
  }

  componentDidMount(){
    axios.get("http://localhost:8080/api/v1/restaurants").then(res=>{
      this.setState({restaurants: res.data.result})
    });

    axios.get("http://localhost:8080/api/v1/restaurants/dishes").then(res=>{
      this.setState({dishes: res.data.result})
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
    // eslint-disable-next-line eqeqeq
    if([prop]=="token"){
      Object.assign(this.state.orderDTO, { [prop]: event.target.value===""? null:new Buffer(event.target.value).toString('base64') })
    }else
    {
      Object.assign(this.state.orderDTO, { [prop]: event.target.value===""? null:event.target.value })
    }
    console.log(this.state.orderDTO)
  };

  orderButtonHandler=()=>{
    let newOrderDto = this.state.orderDTO;
    let extraF=0;
    this.state.orderDTO.orders.forEach(order => {
      extraF = extraF + order.quantity*1.5;
    });
    newOrderDto.extraFees=extraF;
    this.setState(Object.assign(this.state.orderDTO, newOrderDto))

    axios.post("http://localhost:8080/api/v1/orders", this.state.orderDTO).then(res=>{
      console.log(res.data)
    })

  }
  
  render() {
    return (
      <div className="App">
        <div className="inputuri">
          <div>
          <TextFieldMargins onChange={(event)=>this.handleChange(event)}/> 
          </div>
          <div className="cosDeCumparaturi">
            <SimpleMenu orders={this.state.orderDTO.orders.map(
             order=> Object.assign({}, 
              { 
               name: this.state.dishes.find(dish=> dish.id===order.dishId).name, 
                quantity: order.quantity
              }))}/>
          </div>
        </div>
        <div>  
          <OutlinedButtons onClick={()=>{this.orderButtonHandler()}}/>
        </div>
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

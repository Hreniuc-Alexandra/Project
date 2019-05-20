import React, { Component } from 'react';
import './App.css';
import { Restaurant } from './Restaurant/Restaurant.js'
import './Restaurant/Restaurant.css';
import axios from 'axios';

class App extends Component {

  state = {
    restaurants: [   
      // {
      //   id:'1',
      //   imagine:'https://media.mnn.com/assets/images/2017/06/sonic_mushroom_beef_burger.jpg.653x0_q80_crop-smart.jpg', 
      //   nume:'McBurgers',
      //   displayMenu:true,
      //   menu:[
      //     {menuItem: 'bla1', key:1},
      //     {menuItem: 'bla2', key:2},
      //     {menuItem: 'bla3', key:3},
      //     {menuItem: 'bla4', key:4}
      // ]
      // },
      // {
      //   id:'2',
      //   imagine:'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSzQQnwC2wCnzMpEZIYm7EagukKG-GOgwI6kLl9NkHtCgUPskJBQQ',
      //   nume:'Asachi Fried Chicken',
      //   displayMenu:true,
      //   menu:[
      //     {menuItem: 'bla1', key:1},
      //     {menuItem: 'bla2', key:2},
      //     {menuItem: 'bla3', key:3},
      //     {menuItem: 'bla4', key:4}
      // ]
      // },
      // {
      //   id:'3',
      //   imagine:'https://media.istockphoto.com/photos/pepperoni-pizza-italian-pizza-on-white-background-picture-id804291810?k=6&m=804291810&s=612x612&w=0&h=DuLrNMozwV1hgQesN2YghlehYaKZ_VxMv2keZ8b_k9g=',
      //   nume:'Popo Doco',
      //   displayMenu:true,
      //   menu:[
      //     {menuItem: 'bla1', key:1},
      //     {menuItem: 'bla2', key:2},
      //     {menuItem: 'bla3', key:3},
      //     {menuItem: 'bla4', key:4}
      // ]
      // },
      // {
      //   id:'4',
      //   imagine:'http://www.babydigezt.com/wp-content/uploads/2014/09/fish-food.jpg',
      //   nume:'Pescarescu',
      //   displayMenu:true,
      //   menu:[
      //     {menuItem: 'bla1', key:1},
      //     {menuItem: 'bla2', key:2},
      //     {menuItem: 'bla3', key:3},
      //     {menuItem: 'bla4', key:4}
      // ]
      // },
      // {
      //   id:'5',
      //   imagine:'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQJoEO0fyxx6BiFXEO6nT6X3Ojb3Ojzvjf2lYC-o483o_fMpuK-',
      //   nume:'Cofetaria P.M.',
      //   displayMenu:true,
      //   menu:[
      //     {menuItem: 'bla1', key:1},
      //     {menuItem: 'bla2', key:2},
      //     {menuItem: 'bla3', key:3},
      //     {menuItem: 'bla4', key:4}
      // ]
      // }
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
  
  render() {
    
    return (
      <div className="App">
        <div className="zonaTaText">
          Restaurante din zona ta!
        </div>
        <div className="restaurante">
          {this.state.restaurants.map((restaurant,index) => {
            return <Restaurant 
              showMenu={() => {this.showMenuHandler(index)}} 
              // orderClick={this.myCartAdderHandler}
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

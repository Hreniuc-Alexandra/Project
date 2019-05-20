import React from 'react'
import './Restaurant.css'

class Restaurant extends React.Component
{
    // constructor(props){
    //     super(props)

    // }
    insertOrders = dish=> event =>{
        this.props.onOrderClick(dish);
    }
   render(){

        return <div className='cutieRestaurant'>
            
            <img onClick={this.props.showMenu} className='imag' src={this.props.imagine} alt=""/>
            <div className='numeRestaurant'> {this.props.nume}   {this.props.discount===0? null :<h4> {this.props.discount}% reducere la toate produsele! </h4>}      </div>
            {this.props.displayMenu === true ? null : <div>
                <ul>
                   {this.props.menu.map((dish,index)=>{
                        return <li onClick={this.insertOrders(dish.key)} key={index} >{dish.menuItem} - {dish.price} Lei</li>;
                    })}
                </ul>
            </div>}
        </div>;
   }
}

export {Restaurant}
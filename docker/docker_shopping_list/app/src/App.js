import React from 'react';
import './App.css';

class App extends React.Component {

  constructor(props) {
    super(props)
    this.state = {
      list: ["apple", "carrot"],
      cart: ["pizza", "tomatoes"],
      currentItem: '',
    }
  }

  getCurrentItem = (event) => {
    this.setState({currentItem: event.target.value})    
  }

  addItemToList = () => {
    let newList = this.state.list
    newList.push(this.state.currentItem)
    this.setState({list: newList})

  }
  removeItemFromList = (event) => {
    let newList = this.state.list
    let item = newList.indexOf(event.target.name)
    newList.splice(item, 1) 
    this.setState({list : newList})   
  }

  deleteList = () => {
    this.setState({list: []})
  }

  displayList = () => {

      return (
        <div>
          <h1>Shopping List</h1>
          <ul>
              {this.state.list.map(item => <li>{item}<button name={item} onClick={this.removeItemFromList}>Delete</button><button name={item} onClick={this.addItemToCart}>Add Item to Cart</button></li>)}          
          </ul>
        </div>
      )
  }

  addItemToCart = (event) => {
    let item = event.target.name
    this.removeItemFromList(event)
    let newCart = this.state.cart
    newCart.push(item)
    this.setState({cart : newCart})
  }
  
  displayCart = () => {
    return(
      <div>
        <h1>Shopping Cart</h1>
        <ul>
          {this.state.cart.map(item => <li>{item}</li>)}
        </ul>
      </div>
    )
  }

  render () {
    return (
      <div className="App">
      {this.displayList()}
      {this.displayCart()}
      <input type="text" onChange={this.getCurrentItem} />
      <button onClick={this.addItemToList}>Add to List</button>
      <button onClick={this.deleteList}>Delete Shopping List</button>
      </div>
    );
  }
}

export default App;

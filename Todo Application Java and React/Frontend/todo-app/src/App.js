import './App.css'; 
import TodoApp from './components/todo/TodoApp'
// import Counter from './components/counter/Counter'

function App(){
  return(
    <div className='App'>
      {/* <Counter /> */}
      <TodoApp />

    </div>
  )
}

// function PlayingWithprops(properties){
//   console.log(properties);
//   console.log(properties.property1);
//   console.log(properties.property2);

//   return(
//     <div>Props</div>
//   );
// }

// function PlayingWithprops({property1,property2}){
//   console.log(property1);
//   console.log(property2);

//   return(
//     <div>Props</div>
//   );
// }

export default App;

import './App.css';

function App() {
  return (
    <div className="App">Hello React
    </div>
  );
}
const domContainer = document.querySelector('#App_container');
const root = ReactDOM.createRoot(domContainer);
root.render(e(App));

export default App;

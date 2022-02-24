import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import {ApolloClient,ApolloProvider, InMemoryCache} from "@apollo/client";
import { store } from './Pages/store';
import { Provider } from 'react-redux';

const client = new ApolloClient({
  uri:"http://localhost:4000",
  cache: new InMemoryCache(),
});

ReactDOM.render(
  <React.StrictMode>
    <ApolloProvider client={client}>
    <Provider store={store}>
    <App />
    </Provider>
    </ApolloProvider>
  </React.StrictMode>,
  document.getElementById('root')
);



import React, { Component } from 'react';

import { Layout } from 'antd';
import Header from '../components/Header';
import Main from '../components/Main';
import Footer from '../components/Footer';

const { Content } = Layout;

class App extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <Layout className="container">
        <Header />
        <Content style={{ padding: '0 50px' }}>
          <Main />
        </Content>
        <Footer />
      </Layout>
    );
  }
}

export default App;

import React, { Component } from 'react';

import { Layout } from 'antd';

const LayoutHeader = Layout.Header;

class Header extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (
      <LayoutHeader className="header">
        <div className="container">
          <div className="title" >
            Locations App
          </div>
        </div>
      </LayoutHeader>
    );
  }
}

export default Header;

import React, { Component } from 'react';

import { Layout } from 'antd';

const LayoutFooter = Layout.Footer;

class Footer extends Component {
  constructor(props) {
    super(props);
  }

  render() {
    return (

      <LayoutFooter style={{ textAlign: 'center' }}>Powered by Spring Boot and React</LayoutFooter>

    );
  }
}

export default Footer;

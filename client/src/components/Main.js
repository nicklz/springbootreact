import React, { Component } from 'react';

import Locations from '../components/Locations';

import { Layout, DatePicker } from 'antd';

const { RangePicker } = DatePicker;
const { Sider, Content } = Layout;
const FilterContent = Layout.Content;

class Main extends Component {
  constructor(props) {
    super(props);
    this.state = {
      locations: [],
      startDate: 0,
      endDate: 2000000000,
      url: ''
    };


    this.update = this.update.bind(this);

  }

  componentDidMount() {
    this.getAPI()
  }

  getAPI() {
    let url = `http://localhost:8080/api/locations/list?startDate=${this.state.startDate}&endDate=${this.state.endDate}`;

    this.setState({
      url: url
    });

    fetch(url, {
      "method": "GET",
    })
      .then(response => response.json())
      .then(response => {
        this.setState({
          locations: response
        })
      })
      .catch(err => {
        console.log(err);
      });
  }

  update(date) {
    console.log('event', date);
    if (date.length > 1) {
      let startDate = date[0].unix();
      let endDate = date[1].unix();
      this.setState({ startDate: startDate, endDate: endDate });
    }

    this.getAPI()
  }

  render() {
    return (
      <Layout className="site-layout-background" style={{ padding: '24px 0' }}>
        <Sider className="site-layout-background" width={200}>
          <FilterContent className="filters">
            <RangePicker showTime={false} onChange={(date) => this.update(date)} />
          </FilterContent>
        </Sider>
        <Content style={{ padding: '0 24px', minHeight: 280 }}>
          <h1>{this.state.url !== '' ? this.state.url : 'API URL'}</h1>
          <Locations locations={this.state.locations} />
        </Content>
      </Layout>
    );
  }
}

export default Main;

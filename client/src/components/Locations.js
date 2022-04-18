import React, { Component } from 'react';
import { Table } from 'antd';

class Locations extends Component {
  constructor(props) {
    super(props);
  }
  render() {
    const columns = [
      {
        title: 'ID',
        dataIndex: 'id',
        key: 'id',
      },
      {
        title: 'Location',
        dataIndex: 'name',
        key: 'name'
      }
    ];
    return (
      <Table columns={columns} dataSource={this.props.locations} />
    );
  }
}



export default Locations;

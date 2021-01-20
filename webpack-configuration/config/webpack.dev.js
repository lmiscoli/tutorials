const merge = require('webpack-merge');
const common = require('./webpack.common.js');
const path = require('path');

module.exports = merge(common, {
  mode: 'development',
  devtool: 'inline-source-map',
  devServer: {
    port: 3001,
    contentBase: [
      path.resolve(__dirname, '../src/assets/js'),
      path.resolve(__dirname, '../src/assets/css'),
      path.resolve(__dirname, '../src/views')
    ],
    publicPath: "/",
    watchContentBase: true,
    proxy: {
      '/message': {
        target: `http://localhost:3000/message`,
        pathRewrite: { '^/message': '' },
        secure: false,
        changeOrigin: true
      }
    }


  }
});

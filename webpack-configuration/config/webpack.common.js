var path = require('path');
const MiniCssExtractPlugin = require("mini-css-extract-plugin");
const HtmlWebpackPlugin = require('html-webpack-plugin');
const webpack = require('webpack');

module.exports = {
    module: {
        rules: [{
                test: /\.jsx$/,
                exclude: /node_modules/,
                use: ['babel-loader'],
            }, {
                test: /\.scss$/,
                use: ['style-loader', MiniCssExtractPlugin.loader, 'css-loader', 'sass-loader']
            }, {
                test: /\.css$/,
                use: ['style-loader', MiniCssExtractPlugin.loader, 'css-loader']
            }, {
                test: /\.(html)$/,
                loader: 'html-loader',
                options: {
                    attrs: [':data-image', ':src', 'link:href']
                }
            }
        ]
    },
    entry: {
        'index': path.resolve(__dirname, '../src/assets/js/index.js')
    },

    output: {
        filename: "assets/js/[name].bundle.js",
        path: path.resolve(__dirname, '../dist'),
        publicPath: '/'
    },

    plugins: [
        new webpack.ProvidePlugin({
            $: "jquery",
            jQuery: "jquery"
        }),
        new MiniCssExtractPlugin({
            filename: 'assets/css/[name].bundle.css'
        }),
        new HtmlWebpackPlugin({
            template: 'src/views/index.html',
            inject: true,
            chunks: ['index'],
            filename: 'index.html'
        })
    ]
};
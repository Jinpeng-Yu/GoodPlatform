module.exports = {
  devServer: {
    disableHostCheck: false,
    host: '0.0.0.0',
    port: 8788,
    https: false,
    hotOnly: false, // See https://github.com/vuejs/vue-cli/blob/dev/docs/cli-service.md#configuring-proxy
    proxy: {
      '/myshopping': {
        target: 'http://localhost:8787',
        changeOrigin: true,
        pathRewrite: {
          '^/myshopping': '/myshopping' // pathRewrite方法重写url, 这样配置出来的url为http://localhost:8787/myshopping/...
        }
      }
    }
  }
}

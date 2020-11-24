module.exports = {
    lintOnSave: false,
    devServer : { 
        proxy: {
            '/happyhouse': {
                target: 'http://localhost:8097'
            }
        }
    }
}
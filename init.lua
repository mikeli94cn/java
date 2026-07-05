local dap = require('dap')

dap.adapters.java = function(callback)
  callback({
    type = 'server',
    host = '127.0.0.1',
    port = 5005
  })
end

dap.configurations.java = {
  {
    type = 'java',
    request = 'launch',
    name = "Launch Java Program",
    mainClass = "Main",
    projectName = "your-project-name"
  }
}

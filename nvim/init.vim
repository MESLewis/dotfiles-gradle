" Specify directly for plugins
call plug#begin(stdPath('data' . '/plugged')

" Google Chrome vim interop
Plug 'glacambre/firenvim', { 'do': { _ -> firenvim#install(0) } }

" Initialize plugin system
call plug#end()
set showmatch " show matching bracket
set tabstop=2 " 
set softtabstop=2 " 
set shiftwidth=2 " autoindent width
set number " Add line numbers
set expandtab " convert tab to white space
set wildmode=longest,list " bash-like tab completion
filetype plugin indent on " turn on auto-indent depending on file type
syntax on " syntax highlighting


" Specify directly for plugins
call plug#begin(stdpath('data') . '/plugged')

" Google Chrome vim interop
Plug 'glacambre/firenvim', { 'do': { _ -> firenvim#install(0) } }

" Initialize plugin system
call plug#end()

" Reloads vimrc after saving
if !exists('*ReloadVimrc')
    fun! ReloadVimrc()
	    let save_cursor = getcurpos()
		source $MYVIMRC
		call setpos('.', save_cursor)
	endfun
endif
autocmd! BufWritePost $MYVIMRC call ReloadVimrc

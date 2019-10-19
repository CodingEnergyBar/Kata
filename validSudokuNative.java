charToCnt[board[i][j]]++;
                if(charToCnt[board[i][j]] > 1 && board[i][j] != '.')
                    return false;
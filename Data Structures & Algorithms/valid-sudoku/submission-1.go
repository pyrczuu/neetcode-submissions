func isValidSudoku(board [][]byte) bool {
	var rows [9][9]bool
	var cols [9][9]bool
	var boxes [9][9]bool

	for i := 0; i < 9; i++{
		for j := 0; j < 9; j++{
			if board[i][j] == '.' {
				continue
			}

			box := i/3 * 3 + j/3

			idx := board[i][j] - '1'

			if rows[i][idx] || cols[j][idx] || boxes[box][idx] {
				return false
			}

			rows[i][idx] = true
			cols[j][idx] = true
			boxes[box][idx] = true
		}
	}

	return true
}
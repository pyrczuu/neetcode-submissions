func isValidSudoku(board [][]byte) bool {

	isValidRow := func(row int) bool {
		var isTakenRow [9]bool

		for _, entry := range board[row] {
			idx, err := strconv.Atoi(string(entry))
			if err != nil {
				continue
			}
			idx--
			if isTakenRow[idx] == true {
				return false
			}
			isTakenRow[idx] = true
		}
		return true
	}

	isValidCol := func(col int) bool {

		for column := 0; column < 9; column++ {
			var isTakenCol [9]bool
			for row := 0; row < 9; row++ {
				idx, err := strconv.Atoi(string(board[row][column]))
				if err != nil {
					continue
				}
				idx--
				if isTakenCol[idx] == true {
					return false
				}
				isTakenCol[idx] = true
			}
		}

		return true
	}

	isValidBox := func(rowStart, colStart int) bool {
		var isTakenBox [9]bool

		for i := 0; i < 3; i++ {
			for j := 0; j < 3; j++ {
				idx, err := strconv.Atoi(string(board[rowStart+i][colStart+j]))
				if err != nil {
					continue
				}
				idx--
				if isTakenBox[idx] == true {
					return false
				}
				isTakenBox[idx] = true
			}
		}
		return true
	}

	for row := range board {
		if !isValidRow(row) {
			return false
		}
		for col := range row {
			if !isValidCol(col) {
				return false
			}
		}
		boxStarts := []int{0, 3, 6}
		for _, i := range boxStarts {
			for _, j := range boxStarts {
				if !isValidBox(i, j) {
					return false
				}
			}
		}
	}

	return true
}
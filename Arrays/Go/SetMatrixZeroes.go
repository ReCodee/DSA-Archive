package main

import "fmt"

func bruteForce(matrix [][]int) {
	var m, n int = len(matrix), len(matrix[0])
	dummy := make([][]int, m)

	for i := 0; i < m; i++ {
		dummy[i] = make([]int, n)
		for j := 0; j < n; j++ {
			dummy[i][j] = matrix[i][j]
		}
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if matrix[i][j] == 0 {
				for k := 0; k < m; k++ {
					dummy[k][j] = 0
				}

				for k := 0; k < n; k++ {
					dummy[i][k] = 0
				}
			}
		}
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			matrix[i][j] = dummy[i][j]
		}
	}

}

func optimized(matrix [][]int) {
	var m, n int = len(matrix), len(matrix[0])
	rowdummy := make([]int, m)
	columndummy := make([]int, n)

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if matrix[i][j] == 0 {
				rowdummy[i] = -1
				columndummy[j] = -1
			}
		}
	}

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if rowdummy[i] == -1 || columndummy[j] == -1 {
				matrix[i][j] = 0
			}
		}
	}
}

func optimal(matrix [][]int) {
	var m, n int = len(matrix), len(matrix[0])
	var c bool = false

	for i := 0; i < m; i++ {
		if matrix[i][0] == 0 {
			c = true
		}
		for j := 1; j < n; j++ {
			if matrix[i][j] == 0 {
				matrix[0][j] = 0
				matrix[i][0] = 0
			}
		}
	}

	for i := m - 1; i >= 0; i-- {
		for j := n - 1; j > 0; j-- {
			if matrix[0][j] == 0 || matrix[i][0] == 0 {
				matrix[i][j] = 0
			}
		}
		if c == true {
			matrix[i][0] = 0
		}
	}
}

func main() {
	fmt.Println("Enter Row and Column size")
	var m, n int
	fmt.Scan(&m)
	fmt.Scan(&n)

	matrix := make([][]int, m)

	for i := 0; i < m; i++ {
		matrix[i] = make([]int, n)
		for j := 0; j < n; j++ {
			var input int
			fmt.Scan(&input)
			matrix[i][j] = input
		}
	}

	bruteForce(matrix)

	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			fmt.Print(matrix[i][j])
			fmt.Print(" ")
		}
		fmt.Println(" ")
	}

}

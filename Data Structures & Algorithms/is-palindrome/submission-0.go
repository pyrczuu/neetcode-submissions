func isPalindrome(s string) bool {
	reversed := ""
	var nonAlphanumericRegex = regexp.MustCompile(`[^a-zA-Z0-9 ]+`)

	s = nonAlphanumericRegex.ReplaceAllString(s, "")
	s = strings.ToLower(s)
	s = strings.ReplaceAll(s, " ", "")

	for i := len(s) - 1; i >= 0; i-- {
		reversed += string(s[i])
	}
	return s == reversed
}

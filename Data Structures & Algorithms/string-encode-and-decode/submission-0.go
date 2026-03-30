type Solution struct{}

func (s *Solution) Encode(strs []string) string {
	encoded := ""

	for _, str := range strs {
		for _, char := range str {
			encoded += fmt.Sprintf("%c", (char+100)%255)
		}
		encoded = encoded + fmt.Sprintf("%c", 255)
	}
	return encoded
}

func (s *Solution) Decode(encoded string) []string {
	decoded := []string{}
	word := ""

	for _, char := range encoded {
		if char == 255 {
			decoded = append(decoded, word)
			word = ""
		} else {
			word += fmt.Sprintf("%c", (char-100)%255)
		}
	}

	return decoded
}

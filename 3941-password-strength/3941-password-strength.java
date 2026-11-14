class Solution {
    public int passwordStrength(String password) {

        int strength = 0;
        Set<Character> s = new HashSet<>();

        for (int i = 0; i < password.length(); i++) {

            char c = password.charAt(i);
            
            if (s.contains(c)) continue;
            s.add(c);

            if (Character.isLowerCase(c)) strength++;
            if (Character.isUpperCase(c)) strength += 2;
            if (Character.isDigit(c)) strength += 3;
            if (c == '!' || c == '@' || c == '#' || c == '$') strength += 5;

        }

        return strength;
    }
}
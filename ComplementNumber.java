package leetcode;

/**
 * Given a positive integer, output its complement number.
 * The complement strategy is to flip the bits of its binary representation.
 */

/*
* Example :
        Input: 5
        Output: 2
        Explanation: The binary representation of 5 is 101 (no leading zero bits),
                     and its complement is 010. So you need to output 2.
*/

public class ComplementNumber
{
    public int findComplement(int num)
    {
        int i = 0, res = 0;
        while (num > 0)
        {
            if ((1 & num) == 0)
            {
                res += Math.pow(2, i);
            }
            i++;
            num = num >> 1;
        }
        return res;
    }
}

# LeetCode

This repository contains my solutions of problems on [leetcode.com](leetcode.com).

### Project Structure

The classes in the root directory are the ones solved in the order that they are listed on the website.
The classes in dailychallenges and contest directories are self-explanatory.

### File Structure

The class level javadoc has a link to the problem on the leetcode website.

The class name is derived by converting the problem name to PascalCase, removing any special characters and/or descriptions, and converting roman numerals to arabic.
For example, `Two Sum II - Input Array Is Sorted` becomes `TwoSum2` and `Pow(x, n)` becomes `PowXN`.

For some problems, an external helper class is required such as `ListNode` or `NestedInteger`.
Such models are implemented as inner classes if they are specific to the problem at hand, or moved to a public class in the common package if reusable across problems.

All classes also have a main method with a test case to run locally and test the functionality.

### Time vs Space vs Readability

In general, if the problem is trivial, preference is given to readability and concision.
A lot of easy problems are solved in one line, thanks to Java Streams.

For medium and hard problems, and for TLEs on easy problems, time is preferred over space, unless Space Limit is exceeded, which is rare.

import java.util.Stack;

public class SimplifyPath {
    public static void main(String[] args) {
        String path = "/a//b////c/d//././/..";

        if (path == "" || path.length() == 0)
        {
            System.out.println("/");
        }

        StringBuilder builder = new StringBuilder();

        int tempIndex = 0;

        while (tempIndex < path.length())
        {
            if (path.charAt(tempIndex) != '/')
            {
                break;
            }
            tempIndex++;
        }

        path = path.substring(tempIndex);

        char[] pathArr = path.toCharArray();

        if (pathArr.length > 0)
        {
            builder.append(pathArr[0]);

            for (int index = 1; index < pathArr.length; index++)
            {
                if ((pathArr[index - 1] == pathArr[index] && pathArr[index] == '/') == false)
                {
                    builder.append(pathArr[index]);
                }
            }

            String polishedOutput = builder.toString();

            String[] split = polishedOutput.split("/");

            Stack<String> stringStack = new Stack<>();

            for (String splittedString : split)
            {
                if (splittedString.equals(".."))
                {
                    if (stringStack.empty() == false)
                    {
                        stringStack.pop();
                    }
                }
                else if (splittedString.equals("."))
                {
                    continue;
                }
                else
                {
                    stringStack.push(splittedString);
                }
            }

            StringBuilder finalPath = new StringBuilder("/");

            if (stringStack.size() == 0)
            {
                System.out.println("/");
            }
            else
            {
                for (String tempStr : stringStack)
                {
                    finalPath.append(tempStr).append("/");
                }
            }
            System.out.println(finalPath.substring(0, finalPath.length()-1));
        }
        else
        {
            System.out.println("/");
        }

    }
}

package ChapterEight.TreeProject8_4;

import java.util.*;               // Для использования класса Stack

class Tree
{
    public Node root;             // first node of tree

    // ------------------------------------------------------------
    public Tree()                  // Конструктор
    {
        root = null;
    }                              // Пока нет ни одного узла

    // ------------------------------------------------------------

    // ------------------------------------------------------------
    public void traverse(int traverseType)
    {
        switch(traverseType)
        {
            case 1:
                System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;

            case 2:
                System.out.print("\nInorder traversal:  ");
                inOrder(root);
                break;

            case 3:
                System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }

        System.out.println();
    }

    // ------------------------------------------------------------
    private void preOrder(Node localRoot)
    {
        if(localRoot != null)
        {
            System.out.print(localRoot.iData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    // ------------------------------------------------------------
    private void inOrder(Node localRoot)
    {
        if(localRoot != null)
        {
            System.out.print("(");
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData + " ");
            inOrder(localRoot.rightChild);
            System.out.print(")");
        }
    }

    // ------------------------------------------------------------
    private void postOrder(Node localRoot)
    {
        if(localRoot != null)
        {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.iData + " ");
        }
    }

    // ------------------------------------------------------------
    public void displayTree()
    {
        Stack globalStack = new Stack();
        globalStack.push(root);

        int nBlanks = 32;
        boolean isRowEmpty = false;

        System.out.println(
                "......................................................");

        while(isRowEmpty == false)
        {
            Stack localStack = new Stack();
            isRowEmpty = true;

            for(int j = 0; j < nBlanks; j++)
                System.out.print(' ');

            while(globalStack.isEmpty() == false)
            {
                Node temp = (Node)globalStack.pop();

                if(temp != null)
                {
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if(temp.leftChild != null || temp.rightChild != null)
                        isRowEmpty = false;
                }
                else
                {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }

                for(int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            }

            System.out.println();
            nBlanks /= 2;

            while(localStack.isEmpty() == false)
                globalStack.push(localStack.pop());
        }

        System.out.println(
                "......................................................");
    }

// ------------------------------------------------------------
}  // Конец класса Tree
////////////////////////////////////////////////////////////////
import java.util.Arrays;
 
public class File
{
    private static int LEFT(int i) {
        return (2*i + 1);
    }
 
    private static int RIGHT(int i) {
        return (2*i + 2);
    }

    private static void swap(int[] A, int i, int j)
    {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private static void heapify(int[] A, int i, int size)
    {
        int left = LEFT(i);
        int right = RIGHT(i);
 
        int largest = i;

        if (left < size && A[left] > A[i]) {
            largest = left;
        }
 
        if (right < size && A[right] > A[largest]) {
            largest = right;
        }

        if (largest != i)
        {
            swap(A, i, largest);
            heapify(A, largest, size);
        }
    }

    public static int pop(int[] A, int size)
    {
        if (size <= 0) {
            return -1;
        }
 
        int top = A[0];
        A[0] = A[size-1];
        heapify(A, 0, size - 1);
        return top;
    }
}
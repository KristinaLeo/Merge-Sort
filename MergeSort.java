/*
	Kristina Leo		CS146-06 Dr. Mike Wu

	MergeSort.java: This method demonstrates MergeSort
	on an array of numbers and tells the time in which it took to
	sort each number into the correct ascending order. Based on
	pseudocode from Introduction to Algorithms 3rd Edition.
*/

public class MergeSort
{
	public void merge(int nums[], int p, int mid, int r)
	{

		double inf = Double.POSITIVE_INFINITY;

		int sub1 = mid - p + 1;							
		int sub2 = r - mid;

		int left[] = new int[sub1+ 1];		// Left subarray
		int right[] = new int[sub2 +1];		// Right subarray

		for (int i = 0; i < sub1; i++)		// Loop iterates key through left array.
		{
			left[i] = nums[p + i];
		}

		for (int j = 0; j < sub2; j++)		// Loop iterates key through right array.
		{
			right[j] = nums[mid + j + 1];
		}

		left[sub1] = (int)inf;				// Sentinel to set values past
		right[sub2] = (int)inf; 			// sub1 or sub2 to infinity.

		int i = 0;							// Sets indexes to zero.
		int j = 0; 

		for (int k = p; k <= r ; k++)		// Variable k is the key to swap values
		{
			if (left[i] <= right[j])		// If left value is less/equal to right
			{								// Swap and increment left index value
				nums[k] = left[i];
				i = i + 1;
			}
			else
			{
				nums[k] = right[j];			// Else increment right index value
				j = j + 1;
			}
		}
	}

	public void sorting(int nums[], int p, int r)		
	{
		if (p < r)							// Sorts recursively when L side < R side
		{
			int mid = (p + r)/2;			// Midpoint between arrays
			sorting(nums, p, mid);			// Sorts left side first, then right
			sorting(nums, mid + 1, r);
			merge(nums, p, mid, r);
		}
	}

	public void printing(int nums[])		// Method that prints to console
	{
		for (int i = 0; i < nums.length; i++)
		{
			System.out.print(nums[i] + " ");
		}
	}

	public static void main(String[] args)		// Driver program
	{
		int best[] = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
		int average[] = {0,19,1,18,2,17,3,16,4,15,5,14,6,13,7,12,8,11,9,10};
		int worst[] = {11,14,4,17,15,7,9,5,10,12,1,13,18,2,16,6,0,3,8,19};
		MergeSort m = new MergeSort();

		m.sorting(best, 0,19);
		m.printing(best);
		long start = System.nanoTime();
		long end = System.nanoTime();
		System.out.println("this took " + (end-start) + " ns.");
		System.out.println();

		m.sorting(average,0,19);
		m.printing(average);
		long start2 = System.nanoTime();
		long end2 = System.nanoTime();
		System.out.println("this took " + (end2-start2) + " ns.");
		System.out.println();

		m.sorting(worst,0,19);
		m.printing(worst);
		long start3 = System.nanoTime();
		long end3 = System.nanoTime();
		System.out.println("this took " + (end3-start3) + " ns.");
		System.out.println();
	}
}
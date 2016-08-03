/**
 *  ArrayUtils class
 *  Developer: Luis Regus
 *  Class Introduction to Java
 *  Date: 07/07/2016
 *
 *	Description: This class contains utilities to process arrays.
*/
public class ArrayUtils {
	
	/**
	 *	
	**/
	public static int minValue(int[] list) throws BadArrayException {
		int min = 0;

		if(list == null) {
			throw new BadArrayException("Array is null");
		}else if (list.length == 0) {
			throw new BadArrayException("Array is empty");
		}else {
			min = list[0];
			for(int i = 0; i < list.length; i++) {
				if(list[i] < min) {
					min = list[i];
				}
			}
		}
		return min;		
	}

	public static int[] copyRange(int[] list, int startIndex) throws BadArrayException, ArrayIndexOutOfBoundsException{
		int[] newArr = new int[0];

		if(list == null) {
			throw new BadArrayException("Array is null");
		}else if (startIndex < 0 || startIndex > list.length) {
			throw new ArrayIndexOutOfBoundsException(Integer.toString(startIndex));
		}else if(startIndex != list.length) {
			int length = list.length - startIndex;			
			newArr = new int[length];

			for(int i = 0; i < length; i++) {
                    newArr[i] = list[i+startIndex];
			}
		}
		return newArr;		
	}

	public static int indexOf(int[] list, int searchValue) throws BadArrayException{
		int retVal = -1;
			if(list == null) {
				throw new BadArrayException("Array is null");
			}else if (list.length == 0) {
				return retVal;
			}else {
				for(int i = 0; i < list.length; i++) {
					if(list[i] == searchValue) {
						retVal = i;
						break;
					}
				}
			}
			return retVal;		

	}

	public static int lastIndexOf(int[] list, int searchValue) throws BadArrayException{
		int retVal = -1;
			if(list == null) {
				throw new BadArrayException("Array is null");
			}else if (list.length == 0) {
				return retVal;
			}else {
				for(int i = 0; i < list.length; i++) {
					if(list[i] == searchValue) {
						retVal = i;
					}
				}
			}
			return retVal;		
	}

}

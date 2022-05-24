package executors.exe3.matrix;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Runner {

	private static final int SIZE = 2000;
	//private static final int NUM_THREADS = 3;

	private static final int[][] A = new int[SIZE][SIZE];
	private static final int[][] B = new int[SIZE][SIZE];
	private static final int[][] C = new int[SIZE][SIZE];
	private static final int[][] Cserial = new int[SIZE][SIZE];

	public static void main(String[] args) throws InterruptedException {
		initMatrixes();
		
		long startTime, endTime; 
		float runTime;
		
		
		startTime = System.currentTimeMillis();
		
		multiplyMatrixesSerial(A, B, Cserial);
		
		endTime = System.currentTimeMillis();
		runTime = (float)(endTime-startTime)/1000;
		
		System.out.println("Serial runtime: " + runTime);

		//-----------------------
		startTime = System.currentTimeMillis();
		
		multiplyMatrixesWithThreads(A, B, C);
	
		endTime = System.currentTimeMillis();
		runTime = (float)(endTime-startTime)/1000;
		System.out.println("Threaded runtime: " + runTime);
	}

	public static void multiplyMatrixesWithThreads(int[][] first, int[][] second, int[][] result) throws InterruptedException {
		ExecutorService executorService = Executors.newCachedThreadPool();

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				executorService.execute(new MatrixMultiplyTask(i,j,first,second,result));
			}
		}
		
		executorService.shutdown();
		executorService.awaitTermination(3, TimeUnit.SECONDS);
	}

	static class MatrixMultiplyTask implements Runnable {
		private int line;
		private int col;
		private int[][] matrixA;
		private int[][] matrixB;
		private int[][] resultMatrix;
		
		public MatrixMultiplyTask(int line, int col, int[][] matrixA, int[][] matrixB, int[][] resultMatrix) {
			this.line = line;
			this.col = col;
			this.matrixA = matrixA;
			this.matrixB = matrixB;
			this.resultMatrix = resultMatrix;
		}

		@Override
		public void run() {
			resultMatrix[line][col] = 0;
			for (int k = 0; k < SIZE; k++) {
				resultMatrix[line][col] += matrixA[line][k] * matrixB[k][col];
			}
			//System.out.println(Thread.currentThread().getName() + " calculated " + line + "," + col);
		}
		
		
	}

	public static void multiplyMatrixesSerial(int[][] first, int[][] second, int[][] result) {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				result[i][j] = 0;
				for (int k = 0; k < SIZE; k++) {
					result[i][j] += A[i][k] * B[k][j];
				}
			}
		}
	}

	public static void initMatrixes() {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				A[i][j] = 1;
				B[i][j] = 1;
			}
		}
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				System.out.print("[" + matrix[i][j] + "]");
			}
			System.out.println();
		}
	}

}

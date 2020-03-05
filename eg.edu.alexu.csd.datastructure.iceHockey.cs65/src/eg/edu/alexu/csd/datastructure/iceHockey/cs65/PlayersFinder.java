package eg.edu.alexu.csd.datastructure.iceHockey.cs65;

import java.awt.Point;

public class PlayersFinder implements IPlayersFinder{
	@Override
	public Point[] findPlayers(String[] photo, int team, int threshold) {
	      float numberofboxes=threshold/4;
		int rows=photo.length ;
		int columns=photo[0].length();
		//******
		int s = 0;
		int ymax,ymin,xmax,xmin;
		 Point[] output=new Point[1000];
		 for(int y=0;y<1000;y++) {
			 output[y]=new Point(-1,-1);
		 }
		 if(photo.length==0||photo[0].length()==0) {
			 return null;
		 }
		int[][] arr=new int[rows][columns];
		int[][] copy=new int[rows][columns];
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				arr[i][j]=photo[i].charAt(j);
			}	
		}
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
			copy[i][j]=arr[i][j];
				
			}
			
		}
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
		if (copy[i][j]==(team+48)) {
			copy[i][j]=1;
		}
		else {
			copy[i][j]=0;
		}
		
			}
			}
		int newrow=rows+2;
		int newcolumn=columns+2;
		int[][] working=new int[newrow][newcolumn];
		for(int i=0;i<newcolumn;i++) {
			working[0][i]=0;
			working[newrow-1][i]=0;
		}
		for(int i=0;i<newrow;i++) {
			working[i][0]=0;
			working[i][newcolumn-1]=0;
		}
		for(int i=1;i<newrow-1;i++) {
			for(int j=1;j<newcolumn-1;j++) {
			working[i][j]=copy[i-1][j-1];
				
			}	
		}
		boolean flag=true;
		while(flag) {
			flag=false;
			//check if the array is all zeros
			for(int i=1;i<newrow-1;i++) {
				for(int j=1;j<newcolumn-1;j++) {
			if(working[i][j]!=0) {flag=true;break;}	
				}
			}
			//if it is zeros stop the loop
			if(!flag) {
				break;
			}
			//if not then go here and work 
		//	flag=false;
			if (flag) {
			for(int i=1;i<newrow-1;i++) {
				for(int j=1;j<newcolumn-1;j++) {
					if (working[i][j]==1) {
						working[i][j]=4;
						flag=true;
						int counter=0;
					while (flag) {
						flag=false;
						//check for contigious block of ones
						for(int w=1;w<newrow-1;w++) {
							for(int v=1;v<newcolumn-1;v++) {
								if(working[w][v]==1 && working[w+1][v]==4) {working[w][v]=4;counter++;flag=true;}
								if(working[w][v]==1 && working[w-1][v]==4) {working[w][v]=4;counter++;flag=true;}
								if(working[w][v]==1 && working[w][v+1]==4) {working[w][v]=4;counter++;flag=true;}
								if(working[w][v]==1 && working[w][v-1]==4) {working[w][v]=4;counter++;flag=true;}
								//if(working[w][v]==1 && working[w+1][v+1]==4 && (working[w][v+1]==1 || working[w+1][v]==1 )) {working[w][v]=4;counter++;flag=true;}
								//if(working[w][v]==1 && working[w-1][v-1]==4 && (working[w][v-1]==1 || working[w-1][v]==1 )) {working[w][v]=4;counter++;flag=true;}
								//if(working[w][v]==1 && working[w+1][v-1]==4 && (working[w][v-1]==1 || working[w+1][v]==1 )) {working[w][v]=4;counter++;flag=true;}
								//if(working[w][v]==1 && working[w-1][v+1]==4 && (working[w][v+1]==1 || working[w-1][v]==1 )) {working[w][v]=4;counter++;flag=true;}
	
							}
						}
						
						}
						if(counter+1 >= numberofboxes) {
							//(ymax=i-1,,,);
							ymax=i-1;ymin=i-1;xmax=j-1;xmin=j-1;
							for(int w=1;w<newrow-1;w++) {	
								for(int v=1;v<newcolumn-1;v++) {
									if(working[w][v]==4) {
										working[w][v]=0;
										if(v-1>xmax) {xmax=v-1;}
										if(v-1<xmin) {xmin=v-1;}
										if(w-1>ymax) {ymax=w-1;}
										if(w-1<ymin) {ymin=w-1;}
									}
							}
							}
						
							output[s++]= new Point(xmin+xmax+1,ymin+ymax+1);
						}
						else {
							for(int w=1;w<newrow-1;w++) {
								for(int v=1;v<newcolumn-1;v++) {
									if(working[w][v]==4) {
										working[w][v]=0;}	}}}
						
						
					}
						
						
					}
				}
			}
		}
		int sizex=0,addad=0;
		
		for(int f=0;f<output.length;f++) {
			if(output[f].x>-1) {
				sizex++;
			}
		}
		Point[] last = new Point[sizex];
		
		for(int f=0;f<output.length;f++) {
			if(output[f].x>-1) {
                last[addad++]=output[f];
			}
		}
return last;
	}
}

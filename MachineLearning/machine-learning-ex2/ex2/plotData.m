function plotData(X, y)
%PLOTDATA Plots the data points X and y into a new figure 
%   PLOTDATA(x,y) plots the data points with + for the positive examples
%   and o for the negative examples. X is assumed to be a Mx2 matrix.

% Create New Figure
figure; hold on;

% ====================== YOUR CODE HERE ======================
% Instructions: Plot the positive and negative examples on a
%               2D plot, using the option 'k+' for the positive
%               examples and 'ko' for the negative examples.
%
%Find the positive and negative Examples
pos=find(y==1); neg = find(y==0);

%Plot examples

%X(pos,1) is the x-axis with the 1st column of the vector pos
%X(pos,2) is the y-axis
%'k+' creates markers with '+' styling
%LineWidth sets the thickness of +
%MarkerSize sets the size of + Marker
plot(X(pos,1),X(pos,2),'k+','LineWidth', 2, 'MarkerSize', 7);

%'ko' creates marker with 'o' styling
%'MarkerFaceColor', 'y' sets their color as yellow
plot(X(neg,1),X(neg,2),'ko','MarkerFaceColor', 'y', 'MarkerSize', 7);








% =========================================================================



hold off;

end

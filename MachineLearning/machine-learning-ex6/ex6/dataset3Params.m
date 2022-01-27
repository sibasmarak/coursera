function [C, sigma] = dataset3Params(X, y, Xval, yval)
%DATASET3PARAMS returns your choice of C and sigma for Part 3 of the exercise
%where you select the optimal (C, sigma) learning parameters to use for SVM
%with RBF kernel
%   [C, sigma] = DATASET3PARAMS(X, y, Xval, yval) returns your choice of C and 
%   sigma. You should complete this function to return the optimal C and 
%   sigma based on a cross-validation set.
%
val_vector  = [0.01 0.03 0.1 0.3 1 3 10 30];
len = length(val_vector);%8

% You need to return the following variables correctly.
C = 1;
sigma = 0.3;

% ====================== YOUR CODE HERE ======================
% Instructions: Fill in this function to return the optimal C and sigma
%               learning parameters found using the cross validation set.
%               You can use svmPredict to predict the labels on the cross
%               validation set. For example, 
%                   predictions = svmPredict(model, Xval);
%               will return the predictions on the cross validation set.
%
%  Note: You can compute the prediction error using 
%        mean(double(predictions ~= yval))
%
error = 1000000000;
pred = 0;
for i = 1:len,
  C_temp = val_vector(i);
  for j = 1:len,
  sigma_temp = val_vector(j);
  %find the model first
  model = svmTrain(X, y, C_temp, @(x1, x2) gaussianKernel(x1, x2, sigma_temp));
  
  %make predictions
  pred = svmPredict(model, Xval);
  
  %find the hell error
  error_temp =  mean(double(pred ~= yval));

   %do adjustment if necessary
  if error_temp < error,
    error = error_temp;
    C = C_temp;
    sigma = sigma_temp;
  endif
  endfor
endfor




% =========================================================================

end

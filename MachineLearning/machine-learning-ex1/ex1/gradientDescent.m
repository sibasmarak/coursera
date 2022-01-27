function [theta, J_history] = gradientDescent(X, y, theta, alpha, num_iters)
%GRADIENTDESCENT Performs gradient descent to learn theta
%   theta = GRADIENTDESCENT(X, y, theta, alpha, num_iters) updates theta by 
%   taking num_iters gradient steps with learning rate alpha

% Initialize some useful values
m = length(y); % number of training examples
J_history = zeros(num_iters, 1);

new_theta = zeros(length(theta) , 1);
for iter = 1:num_iters

    % ====================== YOUR CODE HERE ======================
    % Instructions: Perform a single gradient step on the parameter vector
    %               theta. 
    %
    % Hint: While debugging, it can be useful to print out the values
    %       of the cost function (computeCost) and gradient here.
    %
      prediction = X * theta;
      random = alpha * 1/m * sum(((prediction - y) .* X),1);
      new_theta = theta - random'; 
      theta = new_theta;
     
     


    % ============================================================

    % Save the cost J in every iteration
    %disp(sprintf('computeCost: %f, i = %f\n', computeCost(X, y, theta), iter))
    J_history(iter) = computeCost(X, y, theta);

end

end

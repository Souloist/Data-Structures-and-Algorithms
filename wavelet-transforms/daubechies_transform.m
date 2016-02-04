% Richard Shen 
% Create a function that applies the daubechies transform given an array and level


function [Cn, array_of_Dn] = Daubechies_transform(array, level)

   len = max(size(array));
   
   % Check to make sure the given number of levels is not too large
   % rounding up with ciel becuase you can still go one level down to a
   % size 1 array
   if level > ceil(log(len)/log(4))
       disp('Please try a smaller depth')
       return
   end
   count = 0;
   array_of_Dn = [];
   
   % dauchies mutlipliers
   
   h0 = (1+sqrt(3))/4*sqrt(2);
   h1 = (3+sqrt(3))/4*sqrt(2);
   h2 = (3-sqrt(3))/4*sqrt(2);
   h3 = (1-sqrt(3))/4*sqrt(2);
   
   % will apply daubechies transform level many times
   while count < level
       
       % checks to made sure that the array is a multiple of 4
       % if it is not, it will pad zeros at the end until the array is a
       % multiple of 4
       if mod(len,4) ~= 0
           array = [array, zeros(1,4-mod(len,4))];
       end

       % Clear sum and difference arrays begining of every loop 
       sum = [];
       difference = [];

       for m = 1:(len/2)-1
           sum(m) = h0*array(2*m-1) + h1*array(2*m) + h2*array(2*m+1)+ h3*array(2*m+2);
           difference(m) = h3*array(2*m-1) - h2*array(2*m) + h1*array(2*m+1) - h0*array(m+2);
       end
       
       % Make sure sum array is a multiple of 4
       if mod(max(size(sum)),4) ~= 0
           sum = [sum, zeros(1,4-mod(max(size(sum)),4))];
       end
       
       % Make sure difference array is a multiple of 4       
       if mod(max(size(difference)),4) ~= 0
           difference = [difference, zeros(1,4-mod(max(size(difference)),4))];
       end       
       
       array_of_Dn = [array_of_Dn, difference];

       % Update new array
       array = sum;
       
       % Update new length
       len = max(size(array));
       count = count + 1;
   end
   
   % Cn is the C(n) for the chosen depth
   Cn = sum;
   
   % array of Dn is an array consisting of [d1 d2 d3 ..etc]
   array_of_Dn = array_of_Dn;
end

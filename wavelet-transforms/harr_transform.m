% Richard Shen 
% Create a function that applies the harr transform given an array and level

function [Cn, array_of_Dn] = harr_transform(array, level)

   len = max(size(array));
   
   % Check to make sure the given number of levels is not too large
   if level > log(len)/log(2)
       disp('Please try a smaller depth')
       return
   end
   count = 0;
   array_of_Dn = [];
   
   % will apply harr transform depth many times
   while count < level
       sum = 0.5*array(1:2:len) + 0.5*array(2:2:len);
       difference = 0.5*array(1:2:len) - 0.5*array(2:2:len);
       array_of_Dn = [array_of_Dn, difference];
       array = sum;
       len = bitshift(len, -1);
       count = count + 1;
   end
   
   % Cn is the C(n) for the chosen depth
   Cn = sum;
   
   % array of Dn is an array consisting of [d1 d2 d3 ..etc]
   array_of_Dn = array_of_Dn;
end

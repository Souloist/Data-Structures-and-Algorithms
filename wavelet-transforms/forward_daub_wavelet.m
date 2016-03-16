% Forward wavelet transform using daub 4 length filter

function [low_output, high_output] = forward_wavelet(array, level)

   len = max(size(array));
   
   % Check to make sure the given number of levels is not too large
   % rounding up with ciel becuase you can still go one level down to a
   % size 1 array
   if level > ceil(log(len)/log(4))
       disp('Please try a smaller depth')
       return
   end
   count = 0;
   
   % dauchies mutlipliers
   
   h0 = (1+sqrt(3))/4*sqrt(2);
   h1 = (3+sqrt(3))/4*sqrt(2);
   h2 = (3-sqrt(3))/4*sqrt(2);
   h3 = (1-sqrt(3))/4*sqrt(2);
   
   % filters
   low_pass = [h0 h1 h2 h3];
   high_pass = [h3 -h2 h1 -h0];
   
   
   % outputs
   low_array = array;
   high_array = array;
   
   %H0 = array(1:2:end,:);  % odd matrix
   %H1 = array(2:2:end,:); % even matrix
   
   % will apply daubechies transform level many times
   while count < level
       
       %low pass filter
       low_output = upfirdn(low_array,low_pass,1,2);
       low_array = low_output;
       
       %high pass filter
       high_output = upfirdn(high_array,high_pass,1,2);
       high_array = high_output;
       count = count + 1;       
   end
   
   low_output
   high_output   

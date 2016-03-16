% Inverse wavelet transform using daub 4 length filter

function [output] = forward_wavelet(low_array, high_array, level)
   
   % dauchies mutlipliers
   
   h0 = (1+sqrt(3))/4*sqrt(2);
   h1 = (3+sqrt(3))/4*sqrt(2);
   h2 = (3-sqrt(3))/4*sqrt(2);
   h3 = (1-sqrt(3))/4*sqrt(2);
   
   coeff = [h0 h1 h2 h3]; 
   low_pass_inverse = fliplr(coeff); % 1/z
   high_pass_inverse = fliplr([h3 -h2 h1 -h0]);
   
   count = 0;
   
   % will apply daubechies transform level many times
   while count < level
       % Convolving and then upsampling the low pass signal
       low_output = upfirdn(low_array,low_pass_inverse,2,1);
       low_array = low_output;
       
       % Concolving and then upsampling the high pass signal
       high_output = upfirdn(high_array,high_pass_inverse,2,1);
       high_array = high_output;       
           
       count = count + 1;       
   end
   
   output = low_output + high_output
%    output = ones(size([low_output high_output]));

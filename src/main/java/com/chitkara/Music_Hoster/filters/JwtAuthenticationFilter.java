package com.chitkara.Music_Hoster.filters;


import com.chitkara.Music_Hoster.security.JwtUtil;
import com.chitkara.Music_Hoster.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private CustomUserDetailService customUserDetailService;


    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

        //get jtw/header
        //Bearer
        //Validate

        //Used to  get headder
        String RequestTokenHeader= httpServletRequest.getHeader("Authorization");
        String username = null;
        String jwtToken = null;

        //Null and Format
        //Check if header is null or not
        if(RequestTokenHeader!=null && RequestTokenHeader.startsWith("Bearer ")){

            jwtToken = RequestTokenHeader.substring(7);

            try{
                username = this.jwtUtil.getUsernameFromToken(jwtToken);

            }catch (Exception e){
                e.printStackTrace();
            }

            UserDetails userDetails = this.customUserDetailService.loadUserByUsername(username);

            //if Username != null and conetex !=null check
            if(username !=null && SecurityContextHolder.getContext().getAuthentication()==null){

                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                        new UsernamePasswordAuthenticationToken (userDetails,null,userDetails.getAuthorities());

                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);

            }
            else{
                System.out.println("Toekn is Not validated ");
            }

        }

        //If user id authenticated then
        filterChain.doFilter(httpServletRequest,httpServletResponse);

    }
}
